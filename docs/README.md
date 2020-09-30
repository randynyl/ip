# User Guide

## Features 

### List tasks 
Lists existing tasks that have been entered.

### Add Todo
Adds a todo task to the list.

### Add Deadline
Adds a deadline task to the list.

### Add Event
Adds an event task to the list.

### Done Task
Marks task as complete.

### Delete Task
Deletes task from task list.

### Find Task
Finds task from list of existing tasks containing keywords.

## Usage

### `list`

Existing tasks in the task list will be shown.

Example of usage: 

'list'

Expected outcome:
  > You currently have no tasks, sire!

  > Here are your tasks, sire: 
  1.[T][✘] read book

### 'todo'

Adds a todo task to the list.

Example of usage:

'todo read book'

Expected outcome:
	> Very well. This task has been added: 
		[T][✘] read book
	> Now you have 1 task in the list.
 
### 'deadline'

Adds a deadline task to the list with a finish-by time separated by '/by'.
Finish-by time must be in the format yyyy-mm-dd.

Example of usage:

'deadline read book /by 2020-10-10'

Expected outcome:
	> Very well. This task has been added: 
		[D][✘] read book (by: Oct 10 2020)
	> Now you have 1 task in the list.

### 'event'

Adds an event task to the list with event details separated by '/at'.

Example of usage:

'event group meeting /at wed 2pm'

Expected outcome:
	> Very well. This task has been added: 
		[E][✘] read book (at: wed 2pm)
	> Now you have 1 task in the list.
  
### 'done'

Marks an existing task as completed.

Example of usage:

'done 1'

Expected outcome:
	> Excellent. This task shall be marked as done: 
	  [T][✓] read book

### 'delete'

Deletes an existing task from the task list.

Example of usage:

'delete 1'

Expected outcome:
	> Very Well. Your task has been removed:
		[T][✓] read book
	> Now you have 0 tasks in the list.

### 'fine'

Finds tasks containing the specified key phrase.

Example of usage:

'find book'

Expected outcome:
	> Here are the matching tasks in your wondrous list:
	1.[D][✘] read book (by: Oct 10 2020)
	2.[D][✘] return book (by: Oct 11 2020)
	3.[E][✘] book fair (at: Nov 18 2pm)
  
