package Features.MultiThreading.ViewModels

import Features.MultiThreading.Usecases.Post

interface PostRepository {
    suspend fun getPost(): Post
    suspend fun incrementPostId()
}
class PostRepositoryImp : PostRepository{
    private var post: Post = Post(1,1,"hello", "hello")

    override suspend fun getPost(): Post {
        return post
    }

    override suspend fun incrementPostId() {
        post.id++
    }
}