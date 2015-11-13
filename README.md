#CoinCraft 

###What this is
This is a minecraft plugin that introduces a new game mode, and allows players to play competitively for bitcoin. The plugin is written in java and makes calls using unirest. Once compiled, the plugin runs on craftbukkit.


##### Playing the game
- Each player goes to the website and registers their bitcoin address, minecraft player name, and pay the buy in (default .001 BTC) 
- Each player joins the server and spawns in a jail
- Each player marks themself ready by punching the note block in the jail
- An area (default 64x64) is defined for the game to be played, and all but one diamond ore block is removed. An invisible fence is created to prevent users from being able to leave the area
- All players are dropped in the area
- The first player to mine the diamond ore block gets the pot of bitcoin sent to their address and the game ends



This project was [@jonjonsonjr](https://github.com/jonjonsonjr), [@nathanph](https://github.com/nathanph) and my submission for [VTHacks](http://vthacks.com/) in Spring of 2015. 
The project won the BookHolders prize, as well as Third place in the overall competition.

![Jon, Nate, and I presenting the project](http://i.imgur.com/RpSJnX1.jpg)

Unfortunately the backend for this plugin is no longer running on heroku, however you're welcome to download it and play with it. Jon's backend code is available [here](https://github.com/jonjonsonjr/pile-of-crap). 

### Aknowledgements 
- [The CraftBukkit project](http://bukkit.org/) for making it possible to complete the project in one night
- [Netbeans IDE](https://netbeans.org/) for making it possible to use maven, without having to use maven
- [Unirest](http://unirest.io/) for allowing me to make web service calls in java, without having to make web service calls in java
