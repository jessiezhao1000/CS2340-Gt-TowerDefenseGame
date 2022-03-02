# M5 Tests
## Sully's Tests
`healthBarDecrements` Tests to see if the health bar visually decreases in size. This helps the player see how much health is remaining for each enemy.

`healthBarFollows` Tests to see if the health bar follows an enemy. This helps the player visually track the health for each enemy.

## Hannah's Tests
My first test checks to make sure the enemy's "dead" variable gets set to true when its health goes to 0 or below. I tested this by subtracting all of the enemy's health and then checking the value of the "dead" variable using the ".isDead()" method. I chose to test this because it is important to our game functionality that we have some way to track if the enemies are dead or not in order to manage the game play and reward the player for the enemies they kill.

My second test checks to make sure the player's money increases when they kill an enemy. I tested this by subtracting the health from an enemy and checking to see if the player's money increased. I chose to test this because it is important that the player has a way to gain money through playing the game, or else they will not be able to continue playing the game after they use up all of their money.

## Daniel's Tests 
My first test will check to ensure that an enemy's health decreases when it passes by a tower.
I will check this by starting the combat and seeing if the health values decrease as the enemies pass by. This is a crucial aspect
of this milestone, so we have to make sure that tower's can properly attack the enemies as they go by. 

My second test will make sure that no enemies get through to the monument with one tower down. I will check by starting 
combat and checking monument health after enough time has elapsed. Based on our current attack values this should not be possible
so it's important to check and make sure it does not happen. 

## Jessie's Tests
My first test is to check if the enemy is appearing in the range of the tower attacking range.

My second test is to check if each different tower does the correct different attack damages on the enemies

##Tamara's Tests
`azulaInit` Tests to ensure that azula has the proper attributes of damage, health, speed, and coin reward since she has different values than zuko and minion because it is a different difficulty level.

`zukoInit` Tests to ensure that azula has the proper attributes of damage, health, speed, and coin reward since he has different values than azula and minion because it is a different difficulty level.
