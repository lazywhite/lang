import React from 'react';
import ReactDOM from 'react-dom';
import Header from './Header.jsx';
import Content from './Content.jsx';
import TableRow from './TableRow.jsx';
import Form from './Form.jsx';
class App extends React.Component {
    constructor(){
        super();
        this.state = {
            data:[]

        }
    this.setStateHandler = this.setStateHandler.bind(this);
    this.forceUpdateHandler = this.forceUpdateHandler.bind(this);
    this.cleanUpHandler = this.cleanUpHandler.bind(this);
    this.changeColorHandler = this.changeColorHandler.bind(this);
    };
    setStateHandler(){
        var item = "setState...";
        var myArray = this.state.data;
        myArray.push(item);
        this.setState({data:myArray}) //set state will trigger update
    };
    forceUpdateHandler(){
        this.forceUpdate()
    };
    
    cleanUpHandler(){
        this.setState({data: []})
    };

    changeColorHandler(){
        var ele = document.getElementById('colorp');
        ReactDOM.findDOMNode(ele).style.color = 'red';
    }
    render(){
        return (
                <div>
                <h1>{this.props.name}</h1>
                <Header />
                <Content />
                <button onClick={this.setStateHandler}>SET STATE</button>
                <button onClick={this.cleanUpHandler}>CLEANUP STATE</button>
                <button onClick={this.forceUpdateHandler}>FORCE UPDATE</button>
                <h4>State Array: {this.state.data}</h4>
                <h3>Random number {Math.random()}</h3>
                <button onClick={this.changeColorHandler}>change color</button>
                <p id="colorp">colorful line</p>
                <Form />
                </div>
               );
    }
}

export default App
