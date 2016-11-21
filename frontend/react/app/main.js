import React from 'react';
import ReactDOM from 'react-dom';
import App from './App.jsx';

ReactDOM.render(<App name="React Demo"/>, document.getElementById('app'))
setTimeout(() => {
       ReactDOM.unmountComponentAtNode(document.getElementById('app'));}, 10000);
