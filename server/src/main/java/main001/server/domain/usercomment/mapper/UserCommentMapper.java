package main001.server.domain.usercomment.mapper;

import main001.server.domain.usercomment.dto.UserCommentDto;
import main001.server.domain.usercomment.entity.UserComment;

public class UserCommentMapper {

    public UserComment postToEntity(UserCommentDto.Post postDto) {
        if(postDto==null) {
            return null;
        }

        UserComment userComment = new UserComment();
        userComment.setContent(postDto.getContent());

        User user = new User();
        user.setUserId(postDto.getUserId());
        userComment.setUser(user);

        User writer = new User();
        writer.setUserId(postDto.getWriterId());
        userComment.setWriter(writer);

        return userComment;
    }

    public UserComment patchToEntity(UserCommentDto.Patch patchDto) {
        if(patchDto==null) {
            return null;
        }

        UserComment userComment = new UserComment();

        userComment.setUserCommentId(patchDto.getUserCommentId());
        userComment.setContent(patchDto.getContent());

        User user = new User();
        user.setUserId(patchDto.getUserId());
        userComment.setUser(user);

        User writer = new User();
        writer.setUserId(patchDto.getWriterId());
        userComment.setWriter(writer);

        return userComment;

    }

    public UserCommentDto.Response entityToResponse(UserComment userComment) {
        UserCommentDto.Response response = new UserCommentDto.Response(
                userComment.getUserCommentId(),
                userComment.getContent(),
                userComment.getUser().getUserId(),
                userComment.getUser().getUserName(),
                userComment.getWriter().getUserId(),
                userComment.getWriter().getUserName(),
                userComment.getCreatedTime(),
                userComment.getModifiedTime()
        );
        return response;
    }
}
