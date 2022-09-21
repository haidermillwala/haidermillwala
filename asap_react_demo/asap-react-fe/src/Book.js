function Book(props) {
    return (
        <div className="card">
            <p>{props.text}</p>
            <button className="btn">Delete</button>
        </div>
    );
}

export default Book;