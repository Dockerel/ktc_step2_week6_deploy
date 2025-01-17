package gift.entity.option;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gift.entity.middle.ProductOption;
import gift.entity.user.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "option")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "옵션 id", nullable = false, example = "1")
    private Long id;
    @Schema(description = "옵션명", nullable = false, example = "그레이 색상")
    private String name;
    @Schema(description = "옵션 수량", nullable = false, example = "5")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "option", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ProductOption> productOption = new ArrayList<>();

    public Option() {
    }

    public Option(OptionDTO optionDTO) {
        this.name = optionDTO.getName();
        this.quantity = optionDTO.getQuantity();
    }

    public void setOptionDTO(OptionDTO optionDTO) {
        this.name = optionDTO.getName();
        this.quantity = optionDTO.getQuantity();
    }

    public void subtract(int quantity) {
        this.quantity -= quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ProductOption> getProductOption() {
        return productOption;
    }

    public void setProductOption(List<ProductOption> productOption) {
        this.productOption = productOption;
    }
}
