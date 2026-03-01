package com.trading.heatmapmobile.network

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

class VaultManager(context: Context) {
    private val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

    private val sharedPreferences = EncryptedSharedPreferences.create(
        "rithmic_vault",
        masterKeyAlias,
        context,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    fun saveCredentials(user: String, pass: String) {
        sharedPreferences.edit().apply {
            putString("rithmic_user", user)
            putString("rithmic_pass", pass)
            apply()
        }
    }

    fun getCredentials(): Pair<String?, String?> {
        val user = sharedPreferences.getString("rithmic_user", null)
        val pass = sharedPreferences.getString("rithmic_pass", null)
        return Pair(user, pass)
    }
}
