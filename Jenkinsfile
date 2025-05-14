pipeline {
    agent any

    environment {
        KATALON_VERSION = '10.2.0'
        KATALON_KEY = 'fb4e1d81-f3d3-4190-9474-a37ce9801ad1'
    }

    stages {
        stage('Prepare Workspace') {
            steps {
                bat '''
                    echo Checking workspace structure...
                    dir

                    if not exist "Test Suites" (
                        echo ERROR: Test Suites directory not found!
                        exit /b 1
                    )

                    if not exist "Reports" (
                        mkdir Reports
                    )
                '''
            }
        }

        stage('Verify Chrome Installation') {
            steps {
                bat '''
                    echo Verifying Google Chrome version...
                    "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe" --version
                    where chrome
                '''
            }
        }

        stage('Execute Tests') {
            steps {
                script {
                    try {
                        executeKatalon(
                            version: env.KATALON_VERSION,
                            executeArgs: "-runMode=console -projectPath=\"${WORKSPACE}\" -retry=0 -testSuitePath=\"Test Suites/TSLogin\" -browserType=\"Chrome (headless)\" -executionProfile=\"default\" -reportFolder=\"${WORKSPACE}/Reports\" -reportFileName=\"TestReport\" -apikey=${env.KATALON_KEY} --config -webui.autoUpdateDrivers=true"
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
                        bat 'dir Reports /s'

                        def reportPath = bat(
                            script: 'for /f "delims=" %%i in (\'dir /s /b Reports\\TSLogin\') do (echo %%i & goto :found) & echo & :found',
                            returnStdout: true
                        ).trim()

                        if (reportPath) {
                            echo "Found report directory at: ${reportPath}"
                            publishHTML([
                                allowMissing: true,
                                alwaysLinkToLastBuild: true,
                                keepAll: true,
                                reportDir: 'Reports/TSLogin',
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
