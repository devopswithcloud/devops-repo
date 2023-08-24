pipeline {
    agent any 
    parameters {
        string (
            name: 'USR_NAME',
            defaultValue: 'Siva',
            description: 'Do enter your name'
        )
        string (
            name: 'CHG_Ticket',
            defaultValue: 'CHG1234',
            description: 'Do enter your name'
        )
        booleanParam(
            name: 'SRE_APPROVED',
            defaultValue: true,
            description: 'Is SRE approval taken for this release'
        )
        choice(
            choices: 'Regular\nHotfix',
            description: "What sort of release is this, regulare release or hotfix ?",
            name: 'Release'
        )
        text(
            name: 'Notes',
            defaultValue: "Enter Release notes",
            description: "Do enter the description"
        )
        credentials(
            name: 'mycrediantials',
            description: "myCredentials", 
            required: true
        )
    }
    stages {
        stage ('Welcome') {
            steps {
                echo "Welcome ${params.USR_NAME}"
                echo "Status of approval ${params.SRE_APPROVED}"
                echo "This is a ${params.Release} Release"
            }
        }
    }
}