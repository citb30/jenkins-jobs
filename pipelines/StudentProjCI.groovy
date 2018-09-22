node {
    stage('Clone-Repo') {
        git 'https://github.com/citb30/studentapp-code.git'
    }
    stage('Build'){
        sh "mvn compile"
    }
    stage('Code-Quality') {
        sh "mvn sonar:sonar -Dsonar.host.url=http://sonarqube:9000 -Dsonar.login=9fd9a621cffbfb18e3fa64e4455d151250a2deb3"
    }
    stage('Packaging') {
        echo 'Making War ffile'
    }
    stage('Dev Deploy') {
        echo "Deploy the war file into Dev Server"
    }
    stage('Selenium Testing') {
        echo "Selenium Testing"
    }
    stage('API Testing'){
        echo "API Testing"
    }
    stage('Upload Artifacts') {
        echo "Upload code to artifacts"
    }
 
} 
