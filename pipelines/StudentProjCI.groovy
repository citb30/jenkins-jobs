node {
    stage('Clone-Repo') {
        git 'https://github.com/citb30/studentapp-code.git'
    }
    stage('Build'){
        sh "mvn compile"
    }
    stage('Code-Quality') {
        echo 'Running Sonarqube scans'
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
