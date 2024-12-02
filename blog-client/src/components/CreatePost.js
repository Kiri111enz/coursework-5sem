import React, { useState } from 'react';
import { useAuth } from '../hooks/useAuth';

const CreatePost = ({ onPostCreated }) => {
  const [title, setTitle] = useState('');
  const [body, setBody] = useState('');
  const [moneyGoal, setMoneyGoal] = useState(1000);
  const { username } = useAuth();

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await onPostCreated({ title, body, username, moneyGoal });
      setTitle('');
      setBody('');
      setMoneyGoal(1000);
    } catch (error) {
      console.error('Failed to create post:', error);
    }
  };

  return (
    <div className="mb-4">
      <h3>Создать новый сбор</h3>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label htmlFor="title" className="form-label">Название</label>
          <input
            type="text"
            className="form-control"
            id="title"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
            required
          />
        </div>
        <div className="mb-3">
          <label htmlFor="body" className="form-label">Описание</label>
          <textarea
            className="form-control"
            id="body"
            rows="3"
            value={body}
            onChange={(e) => setBody(e.target.value)}
            required
          ></textarea>
        </div>
        <div className="mb-3">
          <label htmlFor="goal" className="form-label">Целевая сумма</label>
          <input
            className="form-control"
            id="goal"
            type="number"
            min="1"
            value={moneyGoal}
            onChange={(e) => setMoneyGoal(e.target.value)}
            required
          />
        </div>
        <button type="submit" className="btn btn-primary">Создать пост</button>
      </form>
    </div>
  );
};

export default CreatePost;