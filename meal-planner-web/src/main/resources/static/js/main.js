$(document).ready(function(){

    // FUNCTIONS FOR CLICK DUMMY
    $('#join').click(function(){
        location.href = 'recipes/index.html';
    });

    $('#createAction').click(function(){
        location.href = 'add.html';
    });

    $('#signup').click(function(){
        location.href = 'signup.html';
    });

    $('#login').click(function(){
        location.href = 'login.html';
    });

    $('#loginForm #submit').click(function(){
        location.href = 'week/index.html';
    });

    $('#signupForm #submit').click(function(){
        location.href = 'week/index.html';
    });

    $('#newRecipe').click(function(){
        $('#searchResultList').hide();
        $('#recipeEditor').load('/snippets/recipeEditor.html');
    });

    // ACTUAL FUNCTIONS BEGIN
	

});
