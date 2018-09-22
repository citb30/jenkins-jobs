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
        sh 'mvn package'
    }
    stage('Dev Deploy') {
        build job: 'INSTANCE-CREATE', parameters: [string(name: 'PROJECT_NAME', value: 'student'), string(name: 'ENVIRONMENT', value: 'dev'), string(name: 'SERVER_NAME', value: 'studevapp01'), booleanParam(name: 'RECREATE', value: true)]
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
