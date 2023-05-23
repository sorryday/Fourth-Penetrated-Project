package com.gumi.enjoytrip.domain.post.dao;

import com.gumi.enjoytrip.domain.post.dto.PostCreateDto;
import com.gumi.enjoytrip.domain.post.dto.PostDto;
import com.gumi.enjoytrip.domain.post.dto.PostListDto;
import com.gumi.enjoytrip.domain.post.dto.PostUpdateDto;
import com.gumi.enjoytrip.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDaoImpl implements PostDao {
    private static PostDao instance = null;

    private PostDaoImpl() {
    }

    public static PostDao getInstance() {
        if (instance == null) {
            instance = new PostDaoImpl();
        }
        return instance;
    }

    public List<PostListDto> getPostList() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<PostListDto> postList = new ArrayList<>();
        try {
            connection = DBUtil.getInstance().getConnection();
            String sql = "SELECT p.id, p.title, p.hits, p.is_notice, p.user_id, p.created_at, u.nickname, COUNT(lp.post_id) AS like_count FROM post p JOIN user u ON p.user_id = u.id LEFT OUTER JOIN like_post lp ON p.id = lp.post_id GROUP BY p.id ORDER BY p.is_notice DESC, p.id DESC;";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PostListDto postListDto = new PostListDto();
                postListDto.setId(resultSet.getLong("p.id"));
                postListDto.setTitle(resultSet.getString("p.title"));
                postListDto.setHits(resultSet.getInt("p.hits"));
                postListDto.setIsNotice(resultSet.getBoolean("p.is_notice"));
                postListDto.setCreatorId(resultSet.getLong("p.user_id"));
                postListDto.setCreatedAt(resultSet.getString("p.created_at").substring(0, 16));
                postListDto.setCreatorNickname(resultSet.getString("u.nickname"));
                postListDto.setLikeCount(resultSet.getInt("like_count"));
                postList.add(postListDto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().close(resultSet, preparedStatement, connection);
        }
        return postList;
    }

    public PostDto getPost(long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        PostDto postDto = null;
        try {
            connection = DBUtil.getInstance().getConnection();
            connection.setAutoCommit(false);
            String sql = "SELECT p.id, p.title, p.content, p.hits, p.is_notice, p.user_id, p.created_at, u.nickname, COUNT(lp.post_id) AS like_count FROM post p JOIN user u ON p.user_id = u.id LEFT OUTER JOIN like_post lp ON p.id = lp.post_id WHERE p.id = ? GROUP BY p.id ORDER BY p.is_notice DESC, p.id DESC";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                postDto = new PostDto();
                postDto.setId(resultSet.getLong("p.id"));
                postDto.setTitle(resultSet.getString("p.title"));
                postDto.setContent(resultSet.getString("p.content"));
                postDto.setHits(resultSet.getInt("p.hits"));
                postDto.setIsNotice(resultSet.getBoolean("p.is_notice"));
                postDto.setCreatorId(resultSet.getLong("p.user_id"));
                postDto.setCreatedAt(resultSet.getString("p.created_at").substring(0, 16));
                postDto.setCreatorNickname(resultSet.getString("u.nickname"));
                postDto.setLikeCount(resultSet.getInt("like_count"));
            }
            sql = "UPDATE post SET hits = hits + 1 WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            DBUtil.getInstance().commit(connection);
        } catch (SQLException e) {
            DBUtil.getInstance().rollback(connection);
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().close(resultSet, preparedStatement, connection);
        }
        return postDto;
    }

    public void createPost(PostCreateDto postCreateDto) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getInstance().getConnection();
            String sql = "INSERT INTO post (title, content, user_id) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, postCreateDto.getTitle());
            preparedStatement.setString(2, postCreateDto.getContent());
            preparedStatement.setLong(3, postCreateDto.getCreatorId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().close(preparedStatement, connection);
        }
    }

    public void updatePost(long id, PostUpdateDto postUpdateDto) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getInstance().getConnection();
            String sql = "UPDATE post SET title = ?, content = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, postUpdateDto.getTitle());
            preparedStatement.setString(2, postUpdateDto.getContent());
            preparedStatement.setLong(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().close(preparedStatement, connection);
        }
    }

    public void deletePost(long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getInstance().getConnection();
            String sql = "DELETE FROM post WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().close(preparedStatement, connection);
        }
    }

    public void setNotice(long id, boolean isNotice) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getInstance().getConnection();
            String sql = "UPDATE post SET is_notice = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, isNotice);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().close(preparedStatement, connection);
        }
    }

    @Override
    public List<PostListDto> getPostListByKeyword(String keyword) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<PostListDto> postList = new ArrayList<>();
        try {
            connection = DBUtil.getInstance().getConnection();
            String sql = "SELECT p.id, p.title, p.content, p.hits, p.is_notice, p.user_id, p.created_at, u.nickname, COUNT(lp.post_id) AS like_count FROM post p JOIN user u ON p.user_id = u.id LEFT OUTER JOIN like_post lp ON p.id = lp.post_id WHERE p.title like ? GROUP BY p.id ORDER BY p.is_notice DESC, p.id DESC";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + keyword + "%");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PostListDto postListDto = new PostListDto();
                postListDto.setId(resultSet.getLong("p.id"));
                postListDto.setTitle(resultSet.getString("p.title"));
                postListDto.setHits(resultSet.getInt("p.hits"));
                postListDto.setIsNotice(resultSet.getBoolean("p.is_notice"));
                postListDto.setCreatorId(resultSet.getLong("p.user_id"));
                postListDto.setCreatedAt(resultSet.getString("p.created_at").substring(0, 16));
                postListDto.setCreatorNickname(resultSet.getString("u.nickname"));
                postList.add(postListDto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().close(resultSet, preparedStatement, connection);
        }
        return postList;
    }

    @Override
    public void likePost(long id, long userId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getInstance().getConnection();
            String sql = "INSERT INTO like_post (post_id, user_id) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.setLong(2, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().close(preparedStatement, connection);
        }
    }

    @Override
    public void unlikePost(long id, long userId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getInstance().getConnection();
            String sql = "DELETE FROM like_post WHERE post_id = ? AND user_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.setLong(2, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().close(preparedStatement, connection);
        }
    }
}
