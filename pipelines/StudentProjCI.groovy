node {
    stage('Clone-Repo') {
        echo 'Cloning Repository'
    }
    stage('Build'){
        echo 'Doing Compile'
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
