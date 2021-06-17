import React, { useState, useEffect, Fragment } from 'react';
import './App.css';
import Countdown from 'react-countdown';
import dayjs from 'dayjs';

function App() {
  const [results, setResults] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/active/deals").then(res => res.json()).then(res => setResults(res));
  }, []);

  const handleApiCall = async () => {
    const data = await fetch("http://localhost:8080/refresh/deals");
    setResults(data);
  }

  const Completionist = () => <span>You are good to go!</span>;


  const renderer = ({ hours, minutes, seconds, completed }) => {
    if (completed) {
      // Render a completed state
      return <Completionist />;
    } else {
      // Render a countdown
      return <span>{hours}:{minutes}:{seconds}</span>;
    }
  };

  const getTimer = (val) => {
    return <Countdown
    date={dayjs(val) + 600000}
    renderer={renderer}
  >
    <Completionist />
  </Countdown>
  }

  return (
    <div className="App">
      <table className="card" >
        <tbody>
          <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Discount</th>
            <th>Discount</th>
          </tr>
          {results.length ? results.map((item, index) => {
            return (
              <Fragment>
                <tr key={index}>
                  <td>{item.name}</td>
                  <td>{item.description}</td>
                  <td>{parseInt(item.discount)}</td>
                  <td>Deal ends in {getTimer(item.startTime)}</td>
                </tr>
              </Fragment>
            )
          }) : null}

          {!results.length  && <p style={{textAlign: "center"}}>No Deals</p>}
          </tbody>
      </table>
      <button onClick={() => handleApiCall()}>Refresh</button>
    </div>
  );
}

export default App;
