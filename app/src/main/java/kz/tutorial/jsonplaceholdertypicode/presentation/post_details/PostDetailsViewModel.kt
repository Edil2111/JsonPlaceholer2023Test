package kz.tutorial.jsonplaceholdertypicode.presentation.post_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.entity.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.entity.Post
import kz.tutorial.jsonplaceholdertypicode.domain.use_case.GetPostPreviewCommentsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.use_case.GetPostUseCase

class PostDetailsViewModel(
    private val getPostPreviewCommentsUseCase: GetPostPreviewCommentsUseCase,
    private val getPostUseCase: GetPostUseCase,
    private val postId: Int,
) : ViewModel() {
    private val _postDetailsLiveData: MutableLiveData<Post> = MutableLiveData()
    val postDetailsLiveData: LiveData<Post> = _postDetailsLiveData

    private val _commentsLiveData: MutableLiveData<List<Comment>> = MutableLiveData()
    val commentsLiveData: LiveData<List<Comment>> = _commentsLiveData


    init {
        getPostDetails()
        getPostComments()
    }

    private fun getPostDetails() {
        viewModelScope.launch {
            val postDetails = getPostUseCase.invoke(postId)
            _postDetailsLiveData.value = postDetails
        }

    }

    private fun getPostComments() {
        viewModelScope.launch {
            val postComments = getPostPreviewCommentsUseCase.invoke(postId)
            _commentsLiveData.value = postComments
        }

    }
}