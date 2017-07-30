$(document).ready(function(){

    $('#tryIt').click(function(){
        location.href = 'weeklyPlan.html';
    });

    $('#signup').click(function(){
        location.href = '/signup.html';
    });

    $('#login').click(function(){
        location.href = '/login.html';
    });

    $('#loginForm #submit').click(function(){
        location.href = 'weeklyPlan.html';
    });

    $('#signupForm #submit').click(function(){
        location.href = 'weeklyPlan.html';
    });

});

function CookingJob(recipeID, recipeName){
    this.recipeName = recipeName;
	this.cookingJob = {
			recipeID: recipeID,
			monday: [],
			tuesday: [],
			wednesday: [],
			thursday: [],
			friday: [],
			saturday: [],
			sunday: []
		} ;

	this.addSchedule = function(scheduleDay, mealEvent){
		this.cookingJob[scheduleDay].push(mealEvent);

		var targetObject = $('#week').find('#' + scheduleDay).find('#' + mealEvent);
		$("<li recipeID='" + this.cookingJob[recipeID] + "'>" + this.recipeName + "</li>").appendTo(targetObject);
	};

	this.postCookingJob = function(){
        $.ajax({
            url: "/api/cookingJob",
            method: "POST",
            data: JSON.stringify(this.cookingJob),
            dataType: "json",
            contentType: "application/json"
            }).done(function(msg){
        });
	};
}

function MealPlan() {
	this.createCookingJob = function(recipeID, recipeName){
		return new CookingJob(recipeID, recipeName);
	};
}
