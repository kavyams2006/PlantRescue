
pipeline {
    agent any

    triggers {
        pollSCM('H/1 * * * *')
    }

    stages {
        stage('Install Dependencies') {
            steps {
                bat '"C:/Users/kavya/AppData/Local/Programs/Python/Python313/python.exe" -m pip install -r requirements.txt build'
            }
        }

        stage('Run Tests') {
            steps {
                bat '"C:/Users/kavya/AppData/Local/Programs/Python/Python313/python.exe" -m pytest -v'
            }
        }

        stage('Build Package') {
            steps {
                bat '"C:/Users/kavya/AppData/Local/Programs/Python/Python313/python.exe" -m build'
            }
        }
    }

    post {
        success {
            archiveArtifacts artifacts: 'dist/*.whl, dist/*.tar.gz', fingerprint: true
        }
    }
}
