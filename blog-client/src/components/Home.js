import React, { useState, useEffect } from "react";
import { useAuth } from '../hooks/useAuth';
import PostList from './PostList';
import CreatePost from './CreatePost';
import createPostService from '../api/postService';
import blogImage from "../images/welcomepic.png";

function Home() {
  const { authenticated, username, getAuthToken } = useAuth();
  const [posts, setPosts] = useState([]);
  const [isLoading, setIsLoading] = useState(false);

  const postService = createPostService(getAuthToken);

  const fetchPosts = async () => {
    setIsLoading(true);
    try {
      const fetchedPosts = await postService.getAllPosts();
      setPosts(fetchedPosts);
    } catch (error) {
      console.error('Failed to fetch posts:', error);
    } finally {
      setIsLoading(false);
    }
  };

  useEffect(() => {
    if (authenticated) {
      fetchPosts();
    }
  }, [authenticated]);

  const handlePostCreated = async (newPost) => {
    try {
      await postService.createPost(newPost);
      await fetchPosts();
    } catch (error) {
      console.error('Failed to create post:', error);
    }
  };

  const handlePostDeleted = async (postId) => {
    try {
      await postService.deletePost(postId);
      await fetchPosts();
    } catch (error) {
      console.error('Failed to delete post:', error);
    }
  };

  const handlePostDonated = async (postId, donation) => {
    try {
      await postService.donateToPost(postId, donation);
      await fetchPosts();
    } catch (error) {
      console.error('Failed to donate to post:', error);
    }
  };

  const handleCommentAdded = async () => {
    await fetchPosts(); // Reload posts to reflect new comment count, if applicable
  };

  return (
    <div className="mt-5" style={{ width: '100%', height: '100%' }}>
      {!authenticated ? (
        <div className="row justify-content-center">
          <div className="col-md-8">
              <div className="card-body text-center">
                <h1>Сбор средств и благотворительность</h1>
                <img
                  src={'https://dobrosakha.ru/wp-content/uploads/2023/05/osoznannaya-blagotvoritelnost-scaled.jpg'}
                  className="img-fluid"
                  alt="Welcome to our blog"
                  style={{ maxWidth: '100%', height: 'auto', marginTop: '30px' }}
                />
              </div>
          </div>
        </div>
      ) : (
        <div>
          <CreatePost onPostCreated={handlePostCreated} />
          {isLoading ? (
            <p>Данные загружаются...</p>
          ) : (
            <PostList 
              posts={posts} 
              onPostDeleted={handlePostDeleted}
              onPostDonated={handlePostDonated}
              onCommentAdded={handleCommentAdded}
            />
          )}
        </div>
      )}
    </div>
  );
}

export default Home;