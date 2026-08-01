package it.crystalnest.cobweb.api.registry;

import com.mojang.datafixers.util.Either;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderOwner;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Wrapper around {@link Holder} to implement {@link Supplier}.
 *
 * @param holder wrapped instance of {@link Holder}.
 * @param <T> game object type.
 */
public record CobwebEntry<T>(Holder<T> holder) implements Supplier<T> {
  @NotNull
  @Override
  public T get() {
    return value();
  }

  @NotNull
  public T value() {
    return holder.value();
  }

  public boolean isBound() {
    return holder.isBound();
  }

  public boolean areComponentsBound() {
    return holder.areComponentsBound();
  }

  public boolean is(@NotNull Identifier key) {
    return holder.is(key);
  }

  public boolean is(@NotNull ResourceKey<T> key) {
    return holder.is(key);
  }

  public boolean is(@NotNull Predicate<ResourceKey<T>> predicate) {
    return holder.is(predicate);
  }

  public boolean is(@NotNull TagKey<T> key) {
    return holder.is(key);
  }

  @SuppressWarnings("deprecation")
  public boolean is(@NotNull Holder<T> holder) {
    return this.holder.is(holder);
  }

  @NotNull
  public Stream<TagKey<T>> tags() {
    return holder.tags();
  }

  public @NonNull DataComponentMap components() {
    return holder.components();
  }

  @NotNull
  public Either<ResourceKey<T>, T> unwrap() {
    return holder.unwrap();
  }

  @NotNull
  public Optional<ResourceKey<T>> unwrapKey() {
    return holder.unwrapKey();
  }

  public boolean canSerializeIn(@NotNull HolderOwner<T> owner) {
    return holder.canSerializeIn(owner);
  }

  @NotNull
  public String getRegisteredName() {
    return holder.getRegisteredName();
  }
}