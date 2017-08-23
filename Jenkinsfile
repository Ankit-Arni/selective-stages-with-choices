@Library('selective_stages_with_choices@master')
import Jenkins.model.*
node {
    stage ('Checkout') {
        selective_stages_with_choices.command = 'git credentialsId: 'GITHUB_CRED', url: 'https:/\/github.com/Ankit-Arni/time-tracker.git''
        decideAction()
    }
    
	stage ('Clean') {
        if(action == 'Do this stage')
            bat 'mvn clean'
    	//else if(action == 'Skip to next stage')
    	else {
		    currentBuild.result = 'ABORTED'
	        error("Aborted by user")
    	}
	}
	stage ('Compile') {
	    choice = new ChoiceParameterDefinition('ActionToPerform', ['Do this stage', 'Skip to next stage', 'Abort the build'] as String[], 'Action to be performed')
	    env.ACTION = input message: 'Select the action to be performed', parameters: [choice]
		if(env.ACTION == 'Do this stage')
            bat 'mvn -e compile'
		//else if(env.ACTION == 'Skip to next stage')
		else {
		    currentBuild.result = 'ABORTED'
	        error("Aborted by user")
		}
	}
	stage ('Test') {
        choice = new ChoiceParameterDefinition('ActionToPerform', ['Do this stage', 'Skip to next stage', 'Abort the build'] as String[], 'Action to be performed')
        env.ACTION = input message: 'Select the action to be performed', parameters: [choice]
	    if(env.ACTION == 'Do this stage')
            bat 'mvn -e test'
		//else if(env.ACTION == 'Skip to next stage')
		else {
		    currentBuild.result = 'ABORTED'
	        error("Aborted by user")
		}
	}
	stage ('Package') {
        choice = new ChoiceParameterDefinition('ActionToPerform', ['Do this stage', 'Skip to next stage', 'Abort the build'] as String[], 'Action to be performed')
        env.ACTION = input message: 'Select the action to be performed', parameters: [choice]
	    if(env.ACTION == 'Do this stage')
            bat 'mvn package'
		//else if(env.ACTION == 'Skip to next stage')
		else {
		    currentBuild.result = 'ABORTED'
	        error("Aborted by user")
		}
	}
	stage ('Archive') {
        choice = new ChoiceParameterDefinition('ActionToPerform', ['Do this stage', 'Skip to next stage', 'Abort the build'] as String[], 'Action to be performed')
        env.ACTION = input message: 'Select the action to be performed', parameters: [choice]
	    if(env.ACTION == 'Do this stage')
			archiveArtifacts allowEmptyArchive: true, artifacts: 'web/target/*.?ar', onlyIfSuccessful: true
		//else if(env.ACTION == 'Skip to next stage')
		else {
		    currentBuild.result = 'ABORTED'
	        error("Aborted by user")
		}
    }
}
