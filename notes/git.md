
### Orientation
  * Repository (Set of branches)
      * Local
      * Remote
  * Branch
  * Workspace, Index , Local & Remote (Remote Refs)
    - Index : The git “index” is where you place files you want committed to the git repository.
  * Head, Origin
    - HEAD   : HEAD always refers to the most recent commit on the current branch.
    - HEAD is different from head (head : A head is simply a reference to a commit object.)
    - Origin : default alias on your system for a particular remote repository.
  * File System
     - Single .git folder
     - .gitignore


### Why Git ? Why Branching ?
  - Git is SVN and more
  - What's that more ?
    - Distributed (Entire copy of source database can be in local machines)
    - Local Versioning System
    - GIT branches are not same as SVN branches
    - SVN Tree vs Git Tree
    - Branch (Well Organized)
    - Grouped Commits
       - Proper Version Control
       - Nothing but complete merge goes to main branches
    - with Gitlab Responsibility Isolation and Reviews



### Git Basics & Commands

#### Start a working area
  * init
    - Creates Local Repository
  * clone
    - Copies
    - Ex : get clone $uri

#### Work on the current change
  * add
      - Adds files new Git index
      - Ex : git add . (adds changes to index)
  * mv
  * rm
  * reset
     - with --hard to reset workspace to HEAD

#### Examine the history and state
  * log
     -  Shows the commit logs.
  * show
     -  Shows one or more objects (blobs, trees, tags and commits).
  * status
    - The git status command displays the state of the working directory and the staging area.

#### Grow, mark and tweak your common history
  * branch
    - Lists branches , Creates new branch
    - Ex : git branch -a, git branch $branchName
  * checkout
    - Checks out branches or tags
  * commit
    - Commits the changes to
    - Ex : git commit -m <message>
    - Rollback commit commit --amend 
  * merge
      - Ex :
  * rebase
      - Ex :
  * tag

#### Collaborate (see also: git help workflows)
  * push
  * fetch
  * pull (fetch + merge)

#### Few More
  * diff
     - git diff: Show differences between your working directory and the index.
     - git diff –cached: Show differences between the index and the most recent commit.
     - git diff HEAD: Show the differences between your working directory and the most recent commit.
  * stash
     -  git stash , git stash pop, git stash list, git stash pop <stash>


### Branch Naming Standards
 - Stable builds goes to master
 - Major releases are tagged 
 - Development branch is dev
 - Other branches fallow this naming conventions {story type}-{2-3 word summary}-{tracker id}
 - Story Type  { ft == Feature , bg == Bug, ch == Chore }


### Configure remote repository
~~~
git remote add <REMOTE_ALIAS> <REMOTE_REPO_URI>
ex : git remote add origin https://github.com/phanimaridu/git-demo.git

git config --global credential.helper wincred
git config --global credential.helper cache
git config --global credential.helper "cache --timeout=3600"
git config credential.helper store
git config --unset credential.helper
git config --global credential.helper store
~~~


### Other Useful Commands
~~~
// Create and Checkout branch
git checkout -b <branch>

// Create, Add remote tracking and Checkout branch
git checkout -b <branch> --track <remote>/<branch>

// Show Branch Graph
git log --graph --decorate --pretty=oneline --abbrev-commit --all

// Reset specific file from a branch
git checkout <branch> -- <file> (omit branch to reset to HEAD)

// Diffrence between two branches
git diff <branch1>..<branch2>

// Stashing and popping
git stash save <message>
git stash list
git stash apply stash@{n}

// Resetting to old commit
git reset —hard <commit-sha-ref>


// File History
git log --follow -p -- <file_path>
~~~


### Sources
 - [Git Presentation](https://www.youtube.com/watch?feature=player_detailpage&v=ZDR433b0HJY#t=2791s)
 - [Git Tutorial](https://git-scm.com/book/en/v2/Git-Basics-Getting-a-Git-Repository)
 - [What’s The Deal With The Git Index?](http://stackoverflow.com/questions/3689838/difference-between-head-working-tree-index-in-git)
 - [Git Workflows](https://git-scm.com/docs/gitworkflows)
 - [Difference b/w Head and Working Tree](http://stackoverflow.com/questions/3689838/difference-between-head-working-tree-index-in-git)
 - [5 Fundamental Difference b/w Git & SVN](http://boxysystems.com/index.php/5-fundamental-differences-between-git-svn)
 - [Git Objects](http://www.gitguys.com/topics/all-git-object-types-blob-tree-commit-and-tag/)


