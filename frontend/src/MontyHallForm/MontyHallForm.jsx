import React, { useState } from "react";
import BackendSimulator from "./useBackendSimulator";
import { Button, Container, Table, InputGroup, FormControl, Spinner } from "react-bootstrap";
import "./MontyHallForm.css";

function MontyHallForm() {
    const [numberOfAttempts, setNumberOfAttempts] = useState(1);
    const [changeDoor, setChangeDoor] = useState(true);
    const [response, setResponse] = useState({
        numberOfAttempts: 0,
        successfulAttempts: 0,
        unSuccessfulAttempts: 0,
        successRate: 0.0,
        changedDoor: false
    });
    const ResponseHandler = async () => {
        setIsLoading(true);
        setResponse(await BackendSimulator(numberOfAttempts, changeDoor));
        setIsLoading(false);
    }
    const [isLoading, setIsLoading] = useState(false);

    return (
        <Container className="MontyHallForm">
            <h2>Start your simulation</h2>
            <InputGroup className="mb-3">
                <InputGroup.Text id="number">
                    Input number of attempts
                </InputGroup.Text>
                <FormControl aria-describedby="number" type="number" min="1" onChange={n => setNumberOfAttempts(n.target.value)} />
            </InputGroup>
            <InputGroup className="mb-3">
                <InputGroup.Text id="changedoor">
                    Change door?
                </InputGroup.Text>
                <InputGroup.Checkbox aria-describedby="changedoor" onClick={() => setChangeDoor(!changeDoor)} checked={changeDoor} readOnly />
            </InputGroup>
            <div className="d-grid gap-2">
                {isLoading ? <span><Spinner animation="border" /> Loading </span> : <Button variant="primary" size="lg" onClick={() => ResponseHandler()}> Start</Button>}
            </div>
            <Table className="MontyHallForm">
                <tbody>
                    <tr>
                        <td>Number of attempts </td>
                        <td>{response.numberOfAttempts} </td>
                    </tr>
                    <tr>
                        <td>Successful attempts </td>
                        <td>{response.successfulAttempts} </td>
                    </tr>
                    <tr>
                        <td>Unsuccessful attempts </td>
                        <td>{response.unSuccessfulAttempts} </td>
                    </tr>
                    <tr>
                        <td>Success rate </td>
                        <td>{response.successRate} % </td>
                    </tr>
                    <tr>
                        <td>Changed door </td>
                        <td>{response.changedDoor ? "Door was changed" : "Door was not changed"} </td>
                    </tr>
                </tbody>
            </Table>
        </Container >
    );
}

export default MontyHallForm;


