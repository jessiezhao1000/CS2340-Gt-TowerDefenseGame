# M4 Test
## Sully
enemyInit: Tests to see if the towers are initiated with the right values. \
This should scale with the difficulty to increase the game diffculty.

enemyDraw: Tests to see if the enemy is drawn properly on the screen to give \
the player a visual indication of where the enemy is and how many enemies there\
are..

## Daniel 
enemyValues: checks to make sure the enemy values are set correctly when instantiating an enemy.
This is tested because it is important to ensure that the values are properly set for each 
enemy type to have correct game balance. We check this by creating an enemy in the 
gamestate and comparing the values of the new enemy object to make sure it matches what 
we know they should be.

enemiesEmptyBeforeCombat: checks to make sure the enemies are empty before combat starts,
and this should be checked to make sure the arrayList is empty prior to combat so that there are no 
overlapping enemies or other bugs that could arise as a result.

## Yiqian
startCombat: Test to see will the button be disabled after we click it.
rightText: Test to see if startcombat button has the correct name.

##Hannah
My first tests checks to make sure the player can restart the game when they lose. It does this by navigating to the game over screen and checking if the restart button is visible. I chose to test this because it is important that the user can directly restart the game when they lose, because otherwise they would have to renavigate to the welcome screen manually which is inconvenient. 

My second test checks to be sure the game over screen is displayed when the monument health is less than or equal to zero. It does this by clicking start combat and waiting for the enemies to attack the monument and decrease its health to less than or equal to 0. It then checks that the game over screen is being displayed. This is important to test because the user should not be able to keep playing the game when their monument has 0 or negative health, otherwise the game will never end.


##Tamara
enemiesOnPath: Tests to ensure that the enemy is on the path at the correct \
x value on the screen. This is important because the enemies have to move across\
the path properly so it corresponds to the image of the path

enemyMovement: Tests to ensure that the enemy moves down the path by checking\
that the x value of the enemy changes after the first second after start combat\
being pressed. This is important because the foundational function of this game is\
that the enemies must move across the path and create damage.