node {
    stage("Checkout Source Code"){
        echo "Checkout Source Code"
        checkout scm
    }

    stage ("Run init tests") {
        echo "Running unit tests"
        sh "mvn test"
    }

    stage ("Build project") {
        echo "Build project"
        sh "mvn package -DskipTests"
    }

    stage("Deploy") {
        echo "Deploying project"
        configFileProvider([configFile(fileId: '9c9b5492-c9ce-4f6b-86e7-825a3372f026', variable: 'MAVEN_SETTINGS')]) {
        // Exécuter la commande mvn avec le settings
        sh "mvn deploy -s $MAVEN_SETTINGS -Preposilite"
    }

}
}