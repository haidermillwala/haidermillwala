import logo from './logo.svg';
import './App.css';
import Book from './Book';

function App() {
  return (
    <div>
      <h1>Book Store</h1>
        <div>
          <h2>Books</h2>
          <Book text="Book 1"></Book>
        </div>
    </div>
  );
}

export default App;
