# ImageVoiceEditor-HacktoberFest-2023

# Hacktoberfest23

## What is Hacktoberfest?
A month-long celebration from October 1st - 31st to get people involved in [Open Source](https://github.com/open-source).

![gdsc](https://github.com/Google-DSC-DMCE/TriviaApp-HacktoberFest-2023/assets/101982807/378176a1-da91-46e8-b4d0-fb56ca2c96da)

## Specifically for Hacktoberfest:

  Your PR must be created between October 1 and October 31 (in any time zone, UTC-12 thru UTC+14).
 
  Your PR must be made to a public, unarchived repository.
  
  



# 📌 Videos 📽️:

- [How to pull request [Overview]](https://youtu.be/DIj2q02gvKs)
- [Merge Conflict / comment](https://youtu.be/zOx5PJTY8CI)


# Contribution Rules📚:

- You are allowed to make pull requests that break the rules. We just merge it ;)
- Do NOT add any build steps e.g npm install (we want to keep this a simple static site)
- Do NOT remove other content.
- Styling/code can be pretty, ugly or stupid, big or small as long as it works
<!-- - Add your name to the contributorsList file. -->
- Try to keep pull requests small to minimize merge conflicts


## Getting Started 🤩🤗:


- Fork this repo (button on top)
- Clone on your local machine

```terminal
git clone https://github.com/Google-DSC-DMCE/TriviaApp-HacktoberFest-2023.git
```
- Navigate to project directory.
```terminal
cd TriviaApp-HacktoberFest-2023
```

- Create a new Branch

```markdown
git checkout -b my-new-branch
```

<!--- - Add your Name to `contributors/contributorsList.js`. -->

```markdown
git add .
```
- Commit your changes.

```markdown
git commit -m "Relevant message"
```
- Then push 
```markdown
git push origin my-new-branch
```


- Create a new pull request from your forked repository

<br>

## Installation steps for Project 

Install Android Studio
Open Project in Android Studio
Execute the Main_Activity.java
<br>

## Avoid Conflicts {Syncing your fork}

An easy way to avoid conflicts is to add an 'upstream' for your git repo, as other PR's may be merged while you're working on your branch/fork.   

```terminal
git remote add upstream https://github.com/Google-DSC-DMCE/Expense-Tracker-Hacktober2023.git
```

You can verify that the new remote has been added by typing
```terminal
git remote -v
```

To pull any new changes from your parent repo simply run
```terminal
git merge upstream/master
```

This will give you any eventual conflicts and allow you to easily solve them in your repo. It's a good idea to use it frequently in between your own commits to make sure that your repo is up to date with its parent.

For more information on syncing forks [read this article from Github](https://help.github.com/articles/syncing-a-fork/).
