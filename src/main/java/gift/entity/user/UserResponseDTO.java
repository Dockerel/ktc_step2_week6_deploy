package gift.entity.user;

import io.swagger.v3.oas.annotations.media.Schema;

public class UserResponseDTO {

    @Schema(description = "유저 포인트", nullable = false, example = "1")
    private int point;

    public UserResponseDTO(User user) {
        this.point = user.getPoint();
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
