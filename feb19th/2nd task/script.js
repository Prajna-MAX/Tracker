const API = "http://localhost:3000/books";
const list = document.getElementById("booklist");

async function load() {
  let res = await fetch(API);
  let books = await res.json();
  render(books);
}

function render(books) {

  books.forEach(element => {
    let li = document.createElement("li");
    li.textContent = `${element.id}-${element.title}`;
    li.className = element.available ? "available" : "issued";

    let issue = document.createElement("button");
    issue.textContent = element.available ? "Issue" : "Return";
    issue.onclick = () => toggleBook(element);

    let del = document.createElement("button");
    del.textContent = "Delete";
    del.onclick = () => deleteBook(element.id);

    li.append(issue, del);
    list.appendChild(li);
  });
}

async function toggleBook(book) {
  await fetch(API + "/" + book.id, {
    method: "PATCH",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ available: !book.available })
  });
  load();  
}

async function deleteBook(id) {
  await fetch(API + "/" + id, { method: "DELETE" });
  load();   
}

load();