import React, {useState, useEffect, useMemo} from 'react';
import axios from 'axios';
import Card from 'react-bootstrap/Card';
import {ListGroup} from "react-bootstrap";
import "./AnimalView.css";

const DogsView = () => {
    const [dogsData, setDogsData] = useState([]);

    const fetchData = async () => {
        const response = await axios.get('http://localhost:8080/animals/dogs');
        setDogsData(response.data);
    };

    useEffect(() => {
        fetchData().then(r => r);
    }, []);

    const memoizedDogsData = useMemo(() => dogsData, [dogsData]);

    return (
        <div>
            <h2 className={"title"}>Dogs in Africa</h2>
            <div className={"cards"}>
                {memoizedDogsData.map(dog => (
                    <Card style={{ width: '18rem' }} key={dog[0].id}>
                        <Card.Img variant="top" src={dog[0].image_link} />
                        <Card.Body>
                            <Card.Title>{dog[0].name}</Card.Title>
                        </Card.Body>
                        <ListGroup className="list-group-flush">
                            <ListGroup.Item>Min Life Span: {dog[0].min_life_expectancy }</ListGroup.Item>
                            <ListGroup.Item>Max Life Span: {dog[0].max_life_expectancy}</ListGroup.Item>
                        </ListGroup>
                    </Card>
                ))}
            </div>
        </div>
    );
};

export default DogsView;
