package vn.iotstar.entity;

import java.io.Serializable;
import java.util.List;

import lombok.*;
import jakarta.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "category")
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category implements Serializable{
	private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "CategoryId")
		private int categoryId;

		public int getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(int categoryId) {
			this.categoryId = categoryId;
		}

		@Column(name = "Categoryname", columnDefinition = "NVARCHAR(200) NOT NULL")
		private String categoryname;
		
		@Column(name = "Images", columnDefinition = "NVARCHAR(200) NULL")
		private String images;
		
		@Column(name = "Status")
		private Integer status;
		
		@OneToMany(mappedBy = "category")
		private List<Video> videos;

		public Category() {
		}

		public String getCategoryname() {
			return categoryname;
		}

		public void setCategoryname(String categoryname) {
			this.categoryname = categoryname;
		}

		public String getImages() {
			return images;
		}

		public void setImages(String images) {
			this.images = images;
		}

		public Integer isStatus() {
			return status;
		}

		public void setStatus(int i) {
			this.status = i;
		}

		public List<Video> getVideos() {
			return videos;
		}

		public void setVideos(List<Video> videos) {
			this.videos = videos;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		public Video addVideo(Video video) {
		    getVideos().add(video);
		    video.setCategory(this);
		    return video;
		}

		public Video removeVideo(Video video) {
		    getVideos().remove(video);
		    video.setCategory(null);
		    return video;
		}

		

	}
