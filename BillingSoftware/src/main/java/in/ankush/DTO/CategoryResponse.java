package in.ankush.DTO;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryResponse {
	
	private String categoryId;
	private String name;
	private String description;
	private String bgColor;
	private String imgUrl;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

}
