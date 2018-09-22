node {
    stage('Clone-Repo') {
        dir('CODE') {
            git 'https://github.com/citb30/studentapp-code.git'
        }
    }
    stage('Build'){
        sh "cd CODE ; mvn compile"
    }
    stage('Code-Quality') {
        sh "cd CODE ; mvn sonar:sonar -Dsonar.host.url=http://sonarqube:9000 -Dsonar.login=9fd9a621cffbfb18e3fa64e4455d151250a2deb3"
    }
    stage('Packaging') {
        sh 'cd CODE; mvn package'
    }
    stage('Dev Deploy') {
        // build job: 'INSTANCE-CREATE', parameters: [string(name: 'PROJECT_NAME', value: 'student'), string(name: 'ENVIRONMENT', value: 'dev'), string(name: 'SERVER_NAME', value: 'studevapp01'), booleanParam(name: 'RECREATE', value: true)]
        dir('ANSIBLE') {
            git credentialsId: 'gitrouser', url: 'http://104.196.127.109/engineers/ansible.git'
        }
        sh '''
        cd ANSIBLE
echo 'studevapp01' >hosts 
ansible-playbook -i hosts -u ec2-user playbooks/proj-setup.yml
'''
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
