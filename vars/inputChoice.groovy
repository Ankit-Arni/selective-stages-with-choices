def call () {
    def choice = new ChoiceParameterDefinition('ActionToPerform', ['Do this stage', 'Abort the build'] as String[], 'Action to be performed')
    def action = input message: 'Select the action to be performed', parameters: [choice]
}
