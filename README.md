# NFL Picks Leaderboard

A Java program that tracks weekly NFL picks and shows who's best at picking games.

## The Problem

I argue with freinds about who's best at picking NFL games, but no one actually keeps track. I wanted a way to save everyone's picks and see who's really winning.

## How It Works

A Bash script gets each week's games and scores from ESPN and saves them to a CSV file. Users enter their picks in the Java program, and it checks them against the actual results. Then it shows a leaderboard with each person's record, accuracy, confidence points, and how often they pick upsets.

## Tech Stack

- **Language:** Java and Bash
- **Libraries:** none, just standard Java
- **External tools:** curl, jq, ESPN scoreboard API

## Setup

Java; jq

git clone
cd nfl-picks
chmod +x scripts/*.sh

## Usage

Get the games for a week (example: week 9):

./scripts/fetch_games.sh 9

Run the program:

./scripts/run.sh

Then pick an option from the menu to add picks, update results, or see the leaderboard.

## Roadmap

- [ ] GUI version
- [ ] Automatically get results every week with cron
- [ ] Weekly winners and streaks

## Author

Sumukh - https://github.com/sum07r