$(document).ready(function() {
    $('#subscrForm').bootstrapValidator({
        framework: 'bootstrap',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            name: {
                validators: {
                    notEmpty: {
                        message: 'The full name is required'
                    }
                }
            },
            email: {
            	validators: {
            		notEmpty: {
            			message: 'Email is required.'
            		},
            		emailAddress: {
            			message: 'Enter valid email.'
            		}
            	}
            }
        }
    });
});