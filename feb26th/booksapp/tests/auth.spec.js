import { createStore } from "vuex";
import { describe, it, expect } from "vitest";

describe("Vuex Actions", () => {
  it("login action commits SET_TOKEN mutation on success", async () => {
    const result = await store.actions.login(
      { commit },
      { email: "admin@test.com", password: "1234" },
    );
    expect(commit).toHaveBeenCalledWith("SET_TOKEN", "enterprise-token");
    expect(result).toBe(true);
  });
});
