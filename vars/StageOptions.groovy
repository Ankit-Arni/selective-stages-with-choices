class StageOptions implements Serializable {
    private String command
    def inputChoice () {
        def choice = new ChoiceParameterDefinition('ActionToPerform', ['Do this stage', 'Abort the build'] as String[], 'Action to be performed')
        def action = input message: 'Select the action to be performed', parameters: [choice]
    }
    def setCommand (value) {
        command = value
    }
    /*def checkTypeOfCommand () {
        switch(command) {
            case command.contains("sh") : 
        }
    }*/
    def decideAction () {
        if(action == 'Do this stage')
            command//checkTypeOfCommand()
    	else {
		    currentBuild.result = 'ABORTED'
	        error("Aborted by user")
    	}
    }
}
