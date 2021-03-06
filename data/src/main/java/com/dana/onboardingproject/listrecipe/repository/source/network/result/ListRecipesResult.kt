/*
 * PT. Espay Debit Indonesia Koe.
 * DANA.id
 * Copyright (c) 2017-2022. All Right Reserved.
 */

package com.dana.onboardingproject.listrecipe.repository.source.network.result

import com.google.gson.annotations.SerializedName

/**
 * @author Iga Noviyanti (iga.noviyanti@dana.id)
 * @version ListRecipesResponse, v 0.1 22/04/22 11.23 by Iga Noviyanti
 */
data class ListRecipesResult(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("results")
    val results: List<RecipeItem>? = null
) {
    data class RecipeItem(
        @SerializedName("approved_at")
        val approvedAt: Int? = null,
        @SerializedName("aspect_ratio")
        val aspectRatio: String? = null,
        @SerializedName("beauty_url")
        val beautyUrl: Any? = null,
        @SerializedName("brand")
        val brand: Any? = null,
        @SerializedName("brand_id")
        val brandId: Any? = null,
        @SerializedName("buzz_id")
        val buzzId: Any? = null,
        @SerializedName("canonical_id")
        val canonicalId: String? = null,
        @SerializedName("compilations")
        val compilations: List<Any?>? = null,
        @SerializedName("cook_time_minutes")
        val cookTimeMinutes: String? = null,
        @SerializedName("country")
        val country: String? = null,
        @SerializedName("created_at")
        val createdAt: Int? = null,
        @SerializedName("credits")
        val credits: List<Credit?>? = null,
        @SerializedName("description")
        val description: String? = null,
        @SerializedName("draft_status")
        val draftStatus: String? = null,
        @SerializedName("facebook_posts")
        val facebookPosts: List<Any?>? = null,
        @SerializedName("id")
        val id: Int,
        @SerializedName("inspired_by_url")
        val inspiredByUrl: Any? = null,
        @SerializedName("instructions")
        val instructions: List<Instruction>? = null,
        @SerializedName("is_one_top")
        val isOneTop: Boolean? = null,
        @SerializedName("is_shoppable")
        val isShoppable: Boolean? = null,
        @SerializedName("keywords")
        val keywords: String? = null,
        @SerializedName("language")
        val language: String? = null,
        @SerializedName("name")
        val name: String? = null,
        @SerializedName("num_servings")
        val numServings: Int? = null,
        @SerializedName("nutrition")
        val nutrition: Nutrition? = null,
        @SerializedName("nutrition_visibility")
        val nutritionVisibility: String? = null,
        @SerializedName("original_video_url")
        val originalVideoUrl: Any? = null,
        @SerializedName("prep_time_minutes")
        val prepTimeMinutes: Any? = null,
        @SerializedName("promotion")
        val promotion: String? = null,
        @SerializedName("renditions")
        val renditions: List<Rendition?>? = null,
        @SerializedName("sections")
        val sections: List<Section?>? = null,
        @SerializedName("seo_title")
        val seoTitle: String? = null,
        @SerializedName("servings_noun_plural")
        val servingsNounPlural: String? = null,
        @SerializedName("servings_noun_singular")
        val servingsNounSingular: String? = null,
        @SerializedName("show")
        val show: Show? = null,
        @SerializedName("show_id")
        val showId: Int? = null,
        @SerializedName("slug")
        val slug: String? = null,
        @SerializedName("tags")
        val tags: List<Tag?>? = null,
        @SerializedName("thumbnail_alt_text")
        val thumbnailAltText: String? = null,
        @SerializedName("thumbnail_url")
        val thumbnailUrl: String? = null,
        @SerializedName("tips_and_ratings_enabled")
        val tipsAndRatingsEnabled: Boolean? = null,
        @SerializedName("topics")
        val topics: List<Topic?>? = null,
        @SerializedName("total_time_minutes")
        val totalTimeMinutes: Any? = null,
        @SerializedName("total_time_tier")
        val totalTimeTier: TotalTimeTier? = null,
        @SerializedName("updated_at")
        val updatedAt: Int? = null,
        @SerializedName("user_ratings")
        val userRatings: UserRatings? = null,
        @SerializedName("video_ad_content")
        val videoAdContent: Any? = null,
        @SerializedName("video_id")
        val videoId: Any? = null,
        @SerializedName("video_url")
        val videoUrl: Any? = null,
        @SerializedName("yields")
        val yields: String? = null
    ) {
        data class Credit(
            @SerializedName("id")
            val id: Int? = null,
            @SerializedName("image_url")
            val imageUrl: String? = null,
            @SerializedName("name")
            val name: String? = null,
            @SerializedName("slug")
            val slug: String? = null,
            @SerializedName("type")
            val type: String? = null
        )

        data class Instruction(
            @SerializedName("appliance")
            val appliance: String? = null,
            @SerializedName("display_text")
            val displayText: String? = null,
            @SerializedName("end_time")
            val endTime: Int? = null,
            @SerializedName("id")
            val id: Int? = null,
            @SerializedName("position")
            val position: Int? = null,
            @SerializedName("start_time")
            val startTime: Int? = null,
            @SerializedName("temperature")
            val temperature: String? = null
        )

        data class Nutrition(
            @SerializedName("calories")
            val calories: Int? = null,
            @SerializedName("carbohydrates")
            val carbohydrates: Int? = null,
            @SerializedName("fat")
            val fat: Int? = null,
            @SerializedName("fiber")
            val fiber: Int? = null,
            @SerializedName("protein")
            val protein: Int? = null,
            @SerializedName("sugar")
            val sugar: Int? = null,
            @SerializedName("updated_at")
            val updatedAt: String? = null
        )

        data class Rendition(
            @SerializedName("aspect")
            val aspect: String? = null,
            @SerializedName("bit_rate")
            val bitRate: Int? = null,
            @SerializedName("container")
            val container: String? = null,
            @SerializedName("content_type")
            val contentType: String? = null,
            @SerializedName("duration")
            val duration: Int? = null,
            @SerializedName("file_size")
            val fileSize: Int? = null,
            @SerializedName("height")
            val height: Int? = null,
            @SerializedName("maximum_bit_rate")
            val maximumBitRate: Any? = null,
            @SerializedName("minimum_bit_rate")
            val minimumBitRate: Any? = null,
            @SerializedName("name")
            val name: String? = null,
            @SerializedName("poster_url")
            val posterUrl: String? = null,
            @SerializedName("url")
            val url: String? = null,
            @SerializedName("width")
            val width: Int? = null
        )

        data class Section(
            @SerializedName("components")
            val components: List<Component?>? = null,
            @SerializedName("name")
            val name: Any? = null,
            @SerializedName("position")
            val position: Int? = null
        ) {
            data class Component(
                @SerializedName("extra_comment")
                val extraComment: String? = null,
                @SerializedName("id")
                val id: Int? = null,
                @SerializedName("ingredient")
                val ingredient: Ingredient? = null,
                @SerializedName("measurements")
                val measurements: List<Measurement?>? = null,
                @SerializedName("position")
                val position: Int? = null,
                @SerializedName("raw_text")
                val rawText: String? = null
            ) {
                data class Ingredient(
                    @SerializedName("created_at")
                    val createdAt: Int? = null,
                    @SerializedName("display_plural")
                    val displayPlural: String? = null,
                    @SerializedName("display_singular")
                    val displaySingular: String? = null,
                    @SerializedName("id")
                    val id: Int? = null,
                    @SerializedName("name")
                    val name: String? = null,
                    @SerializedName("updated_at")
                    val updatedAt: Int? = null
                )

                data class Measurement(
                    @SerializedName("id")
                    val id: Int? = null,
                    @SerializedName("quantity")
                    val quantity: String? = null,
                    @SerializedName("unit")
                    val unit: Unit? = null
                ) {
                    data class Unit(
                        @SerializedName("abbreviation")
                        val abbreviation: String? = null,
                        @SerializedName("display_plural")
                        val displayPlural: String? = null,
                        @SerializedName("display_singular")
                        val displaySingular: String? = null,
                        @SerializedName("name")
                        val name: String? = null,
                        @SerializedName("system")
                        val system: String? = null
                    )
                }
            }
        }

        data class Show(
            @SerializedName("id")
            val id: Int? = null,
            @SerializedName("name")
            val name: String? = null
        )

        data class Tag(
            @SerializedName("display_name")
            val displayName: String? = null,
            @SerializedName("id")
            val id: Int? = null,
            @SerializedName("name")
            val name: String? = null,
            @SerializedName("type")
            val type: String? = null
        )

        data class Topic(
            @SerializedName("name")
            val name: String? = null,
            @SerializedName("slug")
            val slug: String? = null
        )

        data class TotalTimeTier(
            @SerializedName("display_tier")
            val displayTier: String? = null,
            @SerializedName("tier")
            val tier: String? = null
        )

        data class UserRatings(
            @SerializedName("count_negative")
            val countNegative: Int? = null,
            @SerializedName("count_positive")
            val countPositive: Int? = null,
            @SerializedName("score")
            val score: Double? = null
        )
    }
}