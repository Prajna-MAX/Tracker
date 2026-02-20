const taskInput = document.getElementById("taskInput");
const addBtn = document.getElementById("addBtn");
const taskList = document.getElementById("taskList");
const dueDate = document.getElementById("dueDate");

let currentFilter = "all";
let tasks = JSON.parse(localStorage.getItem("tasks")) || [];

function saveTasks() {
  localStorage.setItem("tasks", JSON.stringify(tasks));
}

function renderTasks() {
  taskList.innerHTML = "";
  let filteredList = tasks;

  if (currentFilter === "completed") {
    filteredList = tasks.filter(t => t.completed);
  }

  if (currentFilter === "pending") {
    filteredList = tasks.filter(t => !t.completed);
  }

  filteredList.forEach(task => {
    const li = document.createElement("li");
    li.setAttribute("draggable",true);
    if (task.completed) {
      li.classList.add("completed");
    }

    li.innerHTML = `
      ${task.text}
      <small>Due: ${task.dueDate || "No date"}</small>
      <button onclick="toggleComplete(${task.id})">✔</button>
      <button onclick="editTask(${task.id})">Edit</button>
      <button onclick="deleteTask(${task.id})">Delete</button>
    `;

    taskList.appendChild(li);
  });
  enableDragDrop();
}

function setFilter(filter) {
    currentFilter = filter;
    renderTasks();
}



function editTask(id) {
  const task = tasks.find(t => t.id === id);
  if (!task) return;

  const newText = prompt("Edit task:", task.text);
  if (!newText || newText.trim() === "") return;

  task.text = newText.trim();

  saveTasks();
  renderTasks();
}

function deleteTask(id) {
  tasks = tasks.filter(t => t.id !== id);
  saveTasks();
  renderTasks();
}

function enableDragDrop() {

    const items = document.querySelectorAll("#taskList li");

    items.forEach(item => {

        item.addEventListener("dragstart", () => {
            item.classList.add("dragging");
        });

        item.addEventListener("dragend", () => {
            item.classList.remove("dragging");
            updateTaskOrder();
        });
    });

    taskList.addEventListener("dragover", e => {
        e.preventDefault();
        const dragging = document.querySelector(".dragging");
        const afterElement = getDragAfterElement(taskList, e.clientY);

        if (afterElement == null) {
            taskList.appendChild(dragging);
        } else {
            taskList.insertBefore(dragging, afterElement);
        }
    });
}

function updateTaskOrder() {
    const ids = [...taskList.children].map(li => Number(li.dataset.id));
    tasks.sort((a, b) => ids.indexOf(a.id) - ids.indexOf(b.id));
    saveTasks();
}
function getDragAfterElement(container, y) {
    const elements = [...container.querySelectorAll("li:not(.dragging)")];

    return elements.reduce((closest, child) => {
        const box = child.getBoundingClientRect();
        const offset = y - box.top - box.height / 2;

        if (offset < 0 && offset > closest.offset) {
            return { offset: offset, element: child };
        } else {
            return closest;
        }
    }, { offset: Number.NEGATIVE_INFINITY }).element;
}


function toggleComplete(id) {
  const task = tasks.find(t => t.id === id);
  if (!task) return;

  task.completed = !task.completed;

  saveTasks();
  renderTasks();
}

addBtn.addEventListener("click", () => {
  const text = taskInput.value.trim();
  if (text === "") {
    alert("Task cannot be empty");
    return;
  }

  const task = {
    id: Date.now(), 
    text: text,
    dueDate: dueDate.value,
    completed: false
  };

  tasks.push(task);

  taskInput.value = "";
  dueDate.value = "";

  saveTasks();
  renderTasks();
});

