import { postAPI } from '../api';

const createPostService = (getAuthToken) => ({
  getAllPosts: async () => {
    const response = await postAPI.get('/fundraiser/getAllFundraisers', {
      headers: { Authorization: `Bearer ${getAuthToken()}` }
    });
    return response.data;
  },

  createPost: async (postData) => {
    const response = await postAPI.post('/fundraiser/createFundraiser', postData, {
      headers: { Authorization: `Bearer ${getAuthToken()}` }
    });
    return response.data;
  },

  deletePost: async (postId) => {
    await postAPI.delete(`/fundraiser/deleteFundraiser/${postId}`, {
      headers: { Authorization: `Bearer ${getAuthToken()}` }
    });
  },

  donateToPost: async (postId, donation) => {
    await postAPI.put(`/fundraiser/updateFundraiser/${postId}`, { donation }, {
      headers: { Authorization: `Bearer ${getAuthToken()}` }
    });
  }
});

export default createPostService;