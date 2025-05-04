pipeline {
    agent any

    environment {
        KATALON_VERSION = '10.2.0'
        KATALON_KEY = 'fb4e1d81-f3d3-4190-9474-a37ce9801ad1'
    }

    stages {
        stage('Prepare Workspace') {
            steps {
                sh '''
                    echo "Checking workspace structure..."
                    ls -la

                    if [ ! -d "Test Suites" ]; then
                        echo "ERROR: Test Suites directory not found!"
                        exit 1
                    fi

                    mkdir -p Reports
                '''
            }
        }

        stage('Verify Chrome Installation') {
            steps {
                sh '''
                    echo "Verifying Google Chrome version..."
                    google-chrome-stable --version
                    which google-chrome-stable
                '''
            }
        }

        stage('Execute Tests') {
            steps {
                script {
                    try {
                        executeKatalon(
                            version: env.KATALON_VERSION,
                            executeArgs: "-runMode=console -projectPath=${WORKSPACE} -retry=0 -testSuitePath='Test Suites/TSLogin' -browserType='Chrome (headless)' -executionProfile='default' -reportFolder=${WORKSPACE}/Reports -reportFileName='TestReport' -apikey=${env.KATALON_KEY} --config -webui.autoUpdateDrivers=true"
                        )
                    } catch (Exception e) {
                        echo "Test execution failed: ${e.message}"
                        currentBuild.result = 'FAILURE'
                        throw e
                    }
                }
            }
        }

        stage('Publish Reports') {
            steps {
                script {
                    if (fileExists('Reports')) {
                        sh 'ls -la Reports/'

                        def reportPath = sh(script: 'find Reports -type d -name "TSLogin" | head -n 1', returnStdout: true).trim()
                        if (reportPath) {
                            echo "Found report directory at: ${reportPath}"
                            publishHTML([
                                allowMissing: true,
                                alwaysLinkToLastBuild: true,
                                keepAll: true,
                                reportDir: reportPath,
                                reportFiles: '*.html',
                                reportName: 'Katalon Test Report'
                            ])
                        } else {
                            echo "No TSLogin directory found in Reports"
                        }
                    } else {
                        echo "Reports directory does not exist"
                    }
                }
            }
        }
    }
}
