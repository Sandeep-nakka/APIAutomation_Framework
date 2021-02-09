package builders;
import io.minio.BucketExistsArgs;
import io.minio.DownloadObjectArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.UploadObjectArgs;
import io.minio.errors.MinioException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Miniofiledownloader {
  public static void main(String[] args)
      throws IOException, NoSuchAlgorithmException, InvalidKeyException {
    try {
      // Create a minioClient with the MinIO server playground, its access key and secret key.
      MinioClient minioClient =
          MinioClient.builder()
              .endpoint("https://minio.public.discovery.xpms.ai/")
              .credentials("BFF3DOXJ6684K4L5FQQK", "kz8qvjdYciy4CVZotJOjOnB88VG8w44jUVQ6rqVP")
              .build();

      boolean found =
          minioClient.bucketExists(BucketExistsArgs.builder().bucket("benchmark").build());
      if (!found) {
        // Make a new bucket called 'asiatrip'.
        minioClient.makeBucket(MakeBucketArgs.builder().bucket("benchmark").build());
      } else {
        System.out.println("Bucket 'asiatrip' already exists.");
      }

      // Upload '/home/user/Photos/asiaphotos.zip' as object name 'asiaphotos-2015.zip' to bucket
      // 'asiatrip'.
      //minioClient.getObject(GetObjectArgs.builder().bucket("benchmark").object("/benchmark/data/develop1/microservice/scenarios/Build_Smoke_Aggregator_comparator/unstructured_gt.zip").build());
      minioClient.downloadObject(DownloadObjectArgs.builder().bucket("benchmark")
    		  .object("/benchmark/data/develop1/microservice/scenarios/Build_Smoke_Aggregator_comparator/unstructured_gt.zip")
    		  .filename("/home/xpms/Desktop/unstructured_gt.zip")
    		  .build());
      System.out.println("Downlaoded");
//      minioClient.uploadObject(
//          UploadObjectArgs.builder()
//              .bucket("benchmark")
//              .object("new 8.txt")
//              .filename("/home/xpms/Desktop/new 8.txt")
//              .build());
//      System.out.println(
//          "'new 8.txt' is successfully uploaded as "
//              + "object 'new 8.txt' to bucket 'asiatrip'.");
    } catch (MinioException e) {
      System.out.println("Error occurred: " + e);
    }
  }
}
