# NFL Picks Leaderboard

A Java command-line program that tracks weekly NFL picks and shows who's best at picking games.

## The Problem

I argue with friends about who's best at picking NFL games, but no one actually keeps track. I wanted a way to save everyone's picks and see who's really winning.

## How It Works

Game results come from ESPN's public scoreboard and are saved to `data/week.csv`, one finished game per line. The Java program loads those games, lets a player enter picks through a text menu, and saves each pick to `data/picks.csv`. The leaderboard compares each saved pick with its game's real winner, then shows each player's record and accuracy.

![System diagram](docs/diagram.png)

## Tech Stack

* Language: Java and Bash
* Libraries: None
* External tools: curl, jq, ESPN scoreboard API (unofficial, no key needed)
* Data storage: CSV files (`data/week.csv` for games, `data/picks.csv` for picks)

## Setup

Requires Java 25 (tested with OpenJDK Temurin 25.0.4.1). `curl` and `jq` are only needed to fetch a new week of games; the repo already includes a completed week in `data/week.csv`.

```bash
git clone https://github.com/sum07r/nfl_picks.git
cd nfl_picks
chmod +x scripts/run.sh
scripts/run.sh
```

`scripts/run.sh` compiles everything in `src/` into `out/`, then starts the program.

## Usage

The menu has four options:

1. **View Games** lists the games in `data/week.csv`, numbered, away team first.
2. **Make a Pick** asks for your name, a game number, the team you pick, and a confidence from 1 to 5, then saves the pick.
3. **Leaderboard** scores every saved pick and prints each player's record.
4. **Exit** quits.

Example session:

```
<!-- TODO: replace this block with real output pasted from your terminal:
     view the games, make one or two picks, then open the leaderboard -->
```

### Scoring

* Each pick is matched to its game by game ID.
* A pick is correct if the team picked equals the game's winner.
* The leaderboard shows correct picks out of total picks, and the percentage.
* A pick for a game that isn't in `data/week.csv` is ignored.
* Confidence is saved with each pick, but it isn't used in scoring yet.

### Data files

`data/week.csv` (one finished game per line):

```
game_id,date,week,away,away_score,home,home_score,winner
```

`data/picks.csv` (created the first time a pick is saved):

```
Name,Game ID,Pick,Confidence
```

## Project Layout

* `src/Main.java`: starts the program, and has the CSV loading and saving methods
* `src/Menu.java`: the text menu and input checking
* `src/Game.java`: one finished game
* `src/Picks.java`: one player's pick for one game
* `src/PlayerScore.java`: one player's running totals
* `src/Leaderboard.java`: scores the picks and prints standings
* `scripts/run.sh`: compiles and runs the program
* `data/`: `week.csv` and `picks.csv`

## Known Limitations

* The demo uses a completed week, so every game already has a result.
* Fetching a new week is manual.
* Player names are case-sensitive.
* The same player can pick the same game more than once, and both picks count.

## Roadmap

- [x] Set up the repo and README
- [x] Load one week of NFL results into a CSV
- [x] `Game` and `Picks` classes with CSV loading and saving
- [x] Menu for entering picks
- [x] Scoring and a basic leaderboard
- [x] Script to compile and run the program
- [ ] Sort the leaderboard by score
- [ ] Confidence points
- [ ] Upset tracker
- [ ] GUI version
- [ ] Script to fetch a week of results

## Demo

<!-- TODO: link to your video walkthrough -->

## Author

Sumukh - https://github.com/sum07r
