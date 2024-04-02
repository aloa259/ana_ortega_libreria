def call() {
    def abortPipeline = false
    environment{
        scannerHome = tool 'sonar-scanner'
    }
    withSonarQubeEnv(credentialsId: 'TokenJenkins') {
        echo 'Ejecución de las pruebas de calidad de código'
    }
    
    timeout(time: 5, unit: 'MINUTES') {
        waitForQualityGate abortPipeline:true
    }
}
