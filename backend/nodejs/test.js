var Sequelize = require('sequelize')

var seq = new Sequelize('sqlite:///test.db');

var User = seq.define('user',{
	firstname: {
		type: Sequelize.STRING,
		field: 'first_name'
	},
	lastname: {
		type: Sequelize.STRING,
	}
},
{
	freezeTableName: true
});

User.sync({force: true}).then(function () {
	return User.create({
		firstname: 'John',
		lastname: 'Hank',
	});
});
