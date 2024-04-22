import React, {useState, useEffect, useMemo} from 'react';
import axios from 'axios';
import Card from 'react-bootstrap/Card';
import {ListGroup} from "react-bootstrap";
import "./AnimalView.css";

const CatsView = () => {
    const [catsData, setCatsData] = useState([]);

    const fetchData = async () => {
        const response = await axios.get('http://localhost:8080/animals/cats');
        setCatsData(response.data);
    };

    useEffect(() => {
        fetchData().then(r => r);
    }, []);

    const memoizedCatsData = useMemo(() => catsData, [catsData]);

    return (
        <div>
            <h2 className={"title"}>Cats in Africa</h2>
            <div className={"cards"}>
                {memoizedCatsData.map(cat => (
                    <Card style={{ width: '18rem' }} key={cat[0].id}>
                        <Card.Img variant="top" src={cat[0].image_link} />
                        <Card.Body>
                            <Card.Title>{cat[0].name}</Card.Title>
                        </Card.Body>
                        <ListGroup className="list-group-flush">
                            <ListGroup.Item>Min Life Span: {cat[0].min_life_expectancy }</ListGroup.Item>
                            <ListGroup.Item>Max Life Span: {cat[0].max_life_expectancy}</ListGroup.Item>
                        </ListGroup>
                    </Card>
                ))}
            </div>
        </div>
    );
};

export default CatsView;
