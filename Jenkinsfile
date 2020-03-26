node{
    stage("SCM Checkout"){
        git credentialsId :'git-creds', url :'https://github.com/taarh/cinema.git'
    }
    stage("Mvn package"){
        def mvnhome = tool name: 'maven-3', type: 'maven'
        def mvnCMD = "${mvnhome}/bin/mvn"
         sh label: '', script: '${mvnCMD} clean package' 
    }
}
